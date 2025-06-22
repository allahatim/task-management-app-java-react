# Task Management Application

A modern, responsive task management web application built with React, TypeScript, and Tailwind CSS. This application provides user authentication and comprehensive task management capabilities with a clean, intuitive interface.

## 🚀 Features

### Authentication
- **User Registration & Login**: Secure user authentication system
- **Protected Routes**: Automatic redirection for unauthenticated users
- **JWT Token Management**: Secure token-based authentication

### Task Management
- **Create Tasks**: Add new tasks with title, description, and status
- **View Tasks**: Display all tasks in a clean, organized list
- **Edit Tasks**: Modify existing task details
- **Delete Tasks**: Remove tasks with confirmation
- **Task Status**: Track task completion status

### User Experience
- **Responsive Design**: Works seamlessly on desktop, tablet, and mobile devices
- **Modern UI**: Clean, professional interface built with Tailwind CSS
- **Toast Notifications**: Real-time feedback for user actions
- **Form Validation**: Client-side validation using Yup and Formik
- **Loading States**: Smooth user experience with loading indicators

## 🛠️ Technology Stack

### Frontend
- **React 19.1.0** - Modern React with latest features
- **TypeScript 5.8.3** - Type-safe development
- **Vite 6.3.5** - Fast build tool and development server
- **React Router DOM 7.6.2** - Client-side routing
- **Tailwind CSS 3.4.3** - Utility-first CSS framework

### Form Handling & Validation
- **Formik 2.4.6** - Form state management
- **Yup 1.6.1** - Schema validation

### HTTP Client & Notifications
- **Axios 1.10.0** - HTTP client for API requests
- **React Toastify 11.0.5** - Toast notifications

### Development Tools
- **ESLint 9.25.0** - Code linting and formatting
- **PostCSS 8.5.6** - CSS processing
- **Autoprefixer 10.4.21** - CSS vendor prefixing

## 📁 Project Structure

```
src/
├── components/
│   ├── auth/           # Authentication components
│   │   ├── LoginForm.tsx
│   │   └── RegisterForm.tsx
│   ├── common/         # Shared components
│   │   ├── Footer.tsx
│   │   └── Header.tsx
│   ├── tasks/          # Task-related components
│   │   ├── TaskForm.tsx
│   │   └── TaskItem.tsx
│   └── ProtectedRoute.tsx
├── context/
│   └── AuthContext.tsx # Authentication context
├── pages/              # Page components
│   ├── AddTaskPage.tsx
│   ├── EditTaskPage.tsx
│   ├── LoginPage.tsx
│   ├── RegisterPage.tsx
│   └── TasksPage.tsx
├── services/           # API services
│   ├── api.ts
│   ├── auth.ts
│   └── task.ts
└── utils/
    └── constants.ts    # Application constants
```

## 🚀 Getting Started

### Prerequisites

- **Node.js** (version 18 or higher)
- **npm** or **yarn** package manager
- **Backend API** running on `http://localhost:8080` (or update `API_BASE_URL` in `src/utils/constants.ts`)

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd frontend
   ```

2. **Install dependencies**
   ```bash
   npm install
   ```

3. **Start the development server**
   ```bash
   npm run dev
   ```

4. **Open your browser**
   Navigate to `http://localhost:5173` to view the application

### Available Scripts

- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run lint` - Run ESLint
- `npm run preview` - Preview production build

## 🔧 Configuration

### Environment Setup

The application expects a backend API running on `http://localhost:8080`. To change this:

1. Update `API_BASE_URL` in `src/utils/constants.ts`
2. Ensure your backend API is running and accessible

### API Endpoints

The application expects the following API endpoints:

- `POST /auth/register` - User registration
- `POST /auth/login` - User login
- `GET /tasks` - Fetch all tasks
- `POST /tasks` - Create new task
- `PUT /tasks/:id` - Update task
- `DELETE /tasks/:id` - Delete task

## 🎨 Customization

### Styling
The application uses Tailwind CSS for styling. You can customize the design by:

1. Modifying `tailwind.config.js` for theme customization
2. Updating component classes in the respective `.tsx` files
3. Adding custom CSS in `src/index.css`

### Components
All components are modular and can be easily customized or extended. Each component is located in its respective directory under `src/components/`.

## 🔒 Security Features

- **JWT Token Storage**: Tokens stored securely in localStorage
- **Protected Routes**: Automatic authentication checks
- **Form Validation**: Client-side validation prevents invalid data submission
- **API Interceptors**: Automatic token injection for authenticated requests

## 📱 Responsive Design

The application is fully responsive and optimized for:
- **Desktop** (1024px and above)
- **Tablet** (768px - 1023px)
- **Mobile** (below 768px)

## 🧪 Development

### Code Quality
- **TypeScript**: Full type safety throughout the application
- **ESLint**: Code linting and formatting rules
- **React Hooks**: Modern React patterns and best practices

### Best Practices
- **Component Composition**: Reusable, modular components
- **Context API**: Global state management for authentication
- **Custom Hooks**: Encapsulated logic for reusability
- **Error Handling**: Comprehensive error handling and user feedback

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

If you encounter any issues or have questions:

1. Check the [Issues](../../issues) page for existing solutions
2. Create a new issue with detailed information about your problem
3. Include steps to reproduce, expected behavior, and actual behavior

## 🔮 Future Enhancements

- [ ] Task categories and tags
- [ ] Task priority levels
- [ ] Due date functionality
- [ ] Task search and filtering
- [ ] Dark mode theme
- [ ] Task sharing capabilities
- [ ] Offline functionality
- [ ] Push notifications

---

**Built with ❤️ using React, TypeScript, and Tailwind CSS**
