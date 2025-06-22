import { useContext } from 'react';
import { Link } from 'react-router-dom';
import { AuthContext } from '../../context/AuthContext';

const Header = () => {
    const authContext = useContext(AuthContext);

    if (!authContext) {
        return null;
    }

    const { isAuthenticated, logout } = authContext;

    return (
        <header className="bg-white shadow">
            <nav className="container mx-auto px-6 py-3">
                <div className="flex justify-between items-center">
                    <Link to="/tasks" className="text-xl font-semibold text-gray-700">Task Management</Link>
                    <div>
                        {isAuthenticated ? (
                            <button
                                onClick={logout}
                                className="px-4 py-2 text-sm text-white bg-red-500 rounded hover:bg-red-600"
                            >
                                Logout
                            </button>
                        ) : (
                            <>
                                <Link to="/login" className="px-4 py-2 text-sm text-gray-700">Login</Link>
                                <Link to="/register" className="px-4 py-2 text-sm text-white bg-blue-500 rounded hover:bg-blue-600">Register</Link>
                            </>
                        )}
                    </div>
                </div>
            </nav>
        </header>
    );
};

export default Header; 