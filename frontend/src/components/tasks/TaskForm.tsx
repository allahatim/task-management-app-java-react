import { useFormik } from 'formik';
import * as Yup from 'yup';
import { useNavigate, useParams } from 'react-router-dom';
import { createTask, getTask, updateTask, type Task } from '../../services/task';
import { toast } from 'react-toastify';
import { useEffect, useState } from 'react';

const TaskForm = () => {
    const navigate = useNavigate();
    const { id } = useParams<{ id: string }>();
    const [initialValues, setInitialValues] = useState({
        title: '',
        description: '',
        status: 'TODO',
        priority: 'MEDIUM',
        dueDate: '',
    });

    useEffect(() => {
        if (id) {
            const fetchTask = async () => {
                try {
                    const task = await getTask(id);
                    setInitialValues({
                        title: task.title,
                        description: task.description,
                        status: task.status,
                        priority: task.priority,
                        dueDate: new Date(task.dueDate).toISOString().substring(0, 10),
                    });
                } catch (error) {
                    toast.error('Failed to fetch task details.');
                }
            };
            fetchTask();
        }
    }, [id]);

    const formik = useFormik({
        initialValues: initialValues,
        enableReinitialize: true,
        validationSchema: Yup.object({
            title: Yup.string().required('Required'),
            description: Yup.string().required('Required'),
            status: Yup.string().oneOf(['TODO', 'IN_PROGRESS', 'REVIEW', 'COMPLETED', 'CANCELLED']).required('Required'),
            priority: Yup.string().oneOf(['LOW', 'MEDIUM', 'HIGH', 'URGENT']).required('Required'),
            dueDate: Yup.date().required('Required'),
        }),
        onSubmit: async (values) => {
            try {
                if (id) {
                    await updateTask(id, values as Omit<Task, 'id'>);
                    toast.success('Task updated successfully!');
                } else {
                    await createTask(values as Omit<Task, 'id'>);
                    toast.success('Task created successfully!');
                }
                navigate('/tasks');
            } catch (error) {
                toast.error('An error occurred.');
            }
        },
    });

    return (
        <form onSubmit={formik.handleSubmit} className="bg-white p-6 rounded-lg shadow-md">
            {/* Form fields for title, description, status, priority, dueDate */}
            {/* Title */}
            <div className="mb-4">
                <label htmlFor="title" className="block text-gray-700 font-bold mb-2">Title</label>
                <input id="title" type="text" {...formik.getFieldProps('title')} className="w-full px-3 py-2 border rounded" />
                {formik.touched.title && formik.errors.title && <div className="text-red-500 text-sm">{formik.errors.title}</div>}
            </div>

            {/* Description */}
            <div className="mb-4">
                <label htmlFor="description" className="block text-gray-700 font-bold mb-2">Description</label>
                <textarea id="description" {...formik.getFieldProps('description')} className="w-full px-3 py-2 border rounded" />
                {formik.touched.description && formik.errors.description && <div className="text-red-500 text-sm">{formik.errors.description}</div>}
            </div>

            {/* Status */}
            <div className="mb-4">
                <label htmlFor="status" className="block text-gray-700 font-bold mb-2">Status</label>
                <select id="status" {...formik.getFieldProps('status')} className="w-full px-3 py-2 border rounded">
                    <option value="TODO">To Do</option>
                    <option value="IN_PROGRESS">In Progress</option>
                    <option value="REVIEW">Review</option>
                    <option value="COMPLETED">Completed</option>
                    <option value="CANCELLED">Cancelled</option>
                </select>
            </div>

            {/* Priority */}
            <div className="mb-4">
                <label htmlFor="priority" className="block text-gray-700 font-bold mb-2">Priority</label>
                <select id="priority" {...formik.getFieldProps('priority')} className="w-full px-3 py-2 border rounded">
                    <option value="LOW">Low</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HIGH">High</option>
                    <option value="URGENT">Urgent</option>
                </select>
            </div>

            {/* Due Date */}
            <div className="mb-4">
                <label htmlFor="dueDate" className="block text-gray-700 font-bold mb-2">Due Date</label>
                <input id="dueDate" type="date" {...formik.getFieldProps('dueDate')} className="w-full px-3 py-2 border rounded" />
                {formik.touched.dueDate && formik.errors.dueDate && <div className="text-red-500 text-sm">{formik.errors.dueDate}</div>}
            </div>

            <button type="submit" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded" disabled={formik.isSubmitting}>
                {id ? 'Update Task' : 'Add Task'}
            </button>
        </form>
    );
};

export default TaskForm; 