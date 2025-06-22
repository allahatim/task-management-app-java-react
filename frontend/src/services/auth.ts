import api from './api';

interface LoginCredentials {
    email?: string;
    password?: string;
}

interface RegisterUserData {
    firstName?: string;
    lastName?: string;
    username?: string;
    email?: string;
    password?: string;
}

export const login = async (credentials: LoginCredentials) => {
    const response = await api.post('/api/auth/login', credentials);
    return response.data;
};

export const register = async (userData: RegisterUserData) => {
    const response = await api.post('/api/auth/register', userData);
    return response.data;
}; 