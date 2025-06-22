import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getTasks, deleteTask, type Task } from '../services/task';
import TaskItem from '../components/tasks/TaskItem';
import { toast } from 'react-toastify';

const TasksPage = () => {
    const [tasks, setTasks] = useState<Task[]>([]);

    useEffect(() => {
        fetchTasks();
    }, []);

    const fetchTasks = async () => {
        try {
            const tasksData = await getTasks();
            setTasks(tasksData);
        } catch (error) {
            toast.error('Failed to fetch tasks.');
        }
    };

    const handleDelete = async (id: string) => {
        try {
            await deleteTask(id);
            fetchTasks();
            toast.success('Task deleted successfully.');
        } catch (error) {
            toast.error('Failed to delete task.');
        }
    };

    return (
        <div>
            <div className="flex justify-between items-center mb-4">
                <h1 className="text-2xl font-bold">Tasks</h1>
                <Link to="/tasks/new" className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                    Add New Task
                </Link>
            </div>
            <div className="bg-white shadow-md rounded">
                <ul className="divide-y divide-gray-200">
                    {tasks.map((task) => (
                        <TaskItem key={task.id} task={task} onDelete={handleDelete} />
                    ))}
                </ul>
            </div>
        </div>
    );
};

export default TasksPage; 