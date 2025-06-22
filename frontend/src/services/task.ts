import api from './api';

export interface Task {
    id: string;
    title: string;
    description: string;
    status: 'TODO' | 'IN_PROGRESS' | 'REVIEW' | 'COMPLETED' | 'CANCELLED';
    priority: 'LOW' | 'MEDIUM' | 'HIGH' | 'URGENT';
    dueDate: string;
}

export const getTasks = async (): Promise<Task[]> => {
    const response = await api.get('/api/tasks');
    return response.data;
};

export const getTask = async (id: string): Promise<Task> => {
    const response = await api.get(`/api/tasks/${id}`);
    return response.data;
};

export const createTask = async (task: Omit<Task, 'id'>): Promise<Task> => {
    const response = await api.post('/api/tasks', task);
    return response.data;
};

export const updateTask = async (id: string, task: Omit<Task, 'id'>): Promise<Task> => {
    const response = await api.put(`/api/tasks/${id}`, task);
    return response.data;
};

export const deleteTask = async (id: string): Promise<void> => {
    await api.delete(`/api/tasks/${id}`);
};

export const completeTask = async (id: string): Promise<Task> => {
    const response = await api.patch(`/api/tasks/${id}/complete`);
    return response.data;
}; 