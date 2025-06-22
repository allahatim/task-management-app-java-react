import { Link } from 'react-router-dom';
import { type Task, completeTask } from '../../services/task';

interface TaskItemProps {
    task: Task;
    onDelete: (id: string) => void;
}

const TaskItem = ({ task, onDelete }: TaskItemProps) => {

    const handleComplete = async () => {
        try {
            await completeTask(task.id);
            // We should ideally refetch the tasks list or update the state in the parent component
            // For now, we can just reload the page for simplicity, but a better state management would be needed.
            window.location.reload();
        } catch (error) {
            console.error('Failed to complete task', error);
        }
    };

    return (
        <li className="p-4 flex items-center justify-between">
            <div>
                <h3 className="text-lg font-bold">{task.title}</h3>
                <p className="text-sm text-gray-600">{task.description}</p>
                <div className="flex items-center space-x-4 mt-2">
                    <span className={`px-2 inline-flex text-xs leading-5 font-semibold rounded-full ${task.status === 'COMPLETED' ? 'bg-green-100 text-green-800' : 'bg-yellow-100 text-yellow-800'}`}>
                        {task.status}
                    </span>
                    <span className="text-sm text-gray-500">{task.priority}</span>
                    <span className="text-sm text-gray-500">{new Date(task.dueDate).toLocaleDateString()}</span>
                </div>
            </div>
            <div className="flex space-x-2">
                <button
                    onClick={handleComplete}
                    className="text-green-600 hover:text-green-900"
                    disabled={task.status === 'COMPLETED'}
                >
                    Complete
                </button>
                <Link to={`/tasks/edit/${task.id}`} className="text-indigo-600 hover:text-indigo-900">Edit</Link>
                <button onClick={() => onDelete(task.id)} className="text-red-600 hover:text-red-900">Delete</button>
            </div>
        </li>
    );
};

export default TaskItem; 