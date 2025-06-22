# Task Management Application

A full-stack task management application built with **Spring Boot** (Backend) and **React** (Frontend). This application provides a complete solution for managing tasks with user authentication, comprehensive CRUD operations, and a modern, responsive user interface.

## 📋 Table of Contents

- [Features](#-features)
- [Technology Stack](#-technology-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [API Documentation](#-api-documentation)
- [Usage](#-usage)
- [Development](#-development)
- [Testing](#-testing)
- [Deployment](#-deployment)

## ✨ Features

### 🔐 Authentication & Security
- **JWT-based authentication** with secure token generation
- **User registration** and login with email/username
- **Password encryption** using BCrypt
- **Protected routes** with automatic redirection
- **Stateless authentication** for scalability
- **CORS configuration** for secure cross-origin requests

### 📝 Task Management
- **Complete CRUD operations** for tasks
- **Task status management** (TODO, IN_PROGRESS, REVIEW, COMPLETED, CANCELLED)
- **Priority levels** (LOW, MEDIUM, HIGH, URGENT)
- **Due date tracking** with automatic timestamps
- **Task filtering** by status and priority
- **Real-time task updates** with immediate UI feedback

### 🎨 User Experience
- **Responsive design** that works on desktop, tablet, and mobile
- **Modern UI** built with Tailwind CSS
- **Toast notifications** for real-time feedback
- **Form validation** using Yup and Formik
- **Loading states** for smooth user experience
- **Intuitive navigation** with React Router

### 🔧 Technical Features
- **RESTful API** design with proper HTTP status codes
- **Database persistence** with PostgreSQL and JPA/Hibernate
- **ModelMapper** for efficient entity-DTO conversion
- **Comprehensive validation** with Bean Validation
- **Automatic data initialization** with sample tasks
- **TypeScript** for type-safe development

## 🛠️ Technology Stack

### Backend
- **Spring Boot 3.5.0** - Modern Java framework
- **Java 17** - Latest LTS version
- **Spring Security** - Authentication and authorization
- **Spring Data JPA** - Database access layer
- **PostgreSQL** - Primary database
- **JWT** - JSON Web Tokens for authentication
- **Maven** - Dependency management and build tool
- **ModelMapper** - Object mapping utility
- **SpringDoc OpenAPI** - API documentation

### Frontend
- **React 19.1.0** - Modern React with latest features
- **TypeScript 5.8.3** - Type-safe development
- **Vite 6.3.5** - Fast build tool and development server
- **React Router DOM 7.6.2** - Client-side routing
- **Tailwind CSS 3.4.3** - Utility-first CSS framework
- **Formik 2.4.6** - Form state management
- **Yup 1.6.1** - Schema validation
- **Axios 1.10.0** - HTTP client for API requests
- **React Toastify 11.0.5** - Toast notifications

### Development Tools
- **ESLint** - Code linting and formatting
- **PostCSS** - CSS processing
- **Autoprefixer** - CSS vendor prefixing
- **Git** - Version control

## 📁 Project Structure

```
taskmanagement-app/
├── backend/                          # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/io/hahnsoftware/backend/
│   │   │   │   ├── BackendApplication.java
│   │   │   │   ├── config/              # Configuration classes
│   │   │   │   ├── controller/          # REST controllers
│   │   │   │   ├── dto/                 # Data Transfer Objects
│   │   │   │   ├── entity/              # JPA entities
│   │   │   │   ├── filter/              # JWT filter
│   │   │   │   ├── repository/          # Data access layer
│   │   │   │   ├── service/             # Business logic
│   │   │   │   └── exception/           # Custom exceptions
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   └── test/                        # Unit tests
│   ├── pom.xml                          # Maven configuration
│   └── README.md                        # Backend documentation
├── frontend/                        # React Frontend
│   ├── src/
│   │   ├── components/
│   │   │   ├── auth/               # Authentication components
│   │   │   ├── common/             # Shared components
│   │   │   ├── tasks/              # Task-related components
│   │   │   └── ProtectedRoute.tsx
│   │   ├── context/
│   │   │   └── AuthContext.tsx     # Authentication context
│   │   ├── pages/                  # Page components
│   │   ├── services/               # API services
│   │   └── utils/                  # Utility functions
│   ├── package.json                # Node.js dependencies
│   ├── tailwind.config.js          # Tailwind configuration
│   ├── vite.config.ts              # Vite configuration
│   └── README.md                   # Frontend documentation
└── README.md                       # This file
```

## 📋 Prerequisites

Before running this project, ensure you have the following installed:

### Backend Requirements
- **Java 17** or higher
- **Maven 3.6** or higher
- **PostgreSQL 12** or higher
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code)

### Frontend Requirements
- **Node.js** (version 18 or higher)
- **npm** or **yarn** package manager
- **Modern web browser**

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/allahatim/task-management-app-java-react.git
cd task-management-app
```

### 2. Backend Setup

#### Database Configuration
1. **Create PostgreSQL database:**
```sql
CREATE DATABASE taskmanagement;
CREATE USER hahn WITH PASSWORD 'hahn2025';
GRANT ALL PRIVILEGES ON DATABASE taskmanagement TO hahn;
```

2. **Update database configuration** in `backend/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskmanagement
spring.datasource.username=your_username
spring.datasource.password=your_password
```

#### Build and Run Backend
```bash
cd backend
mvn clean compile
mvn spring-boot:run
```

The backend API will be available at `http://localhost:8080`

### 3. Frontend Setup

#### Install Dependencies
```bash
cd frontend
npm install
```

#### Configure API Endpoint
Update the API base URL in `src/utils/constants.ts` if needed:
```typescript
export const API_BASE_URL = 'http://localhost:8080/api';
```

#### Start Development Server
```bash
npm run dev
```

The frontend application will be available at `http://localhost:5173`

## 📚 API Documentation

### Authentication Endpoints

#### Register User
```http
POST /api/auth/register
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "username": "johndoe",
  "email": "john@example.com",
  "password": "password123"
}
```

#### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "johndoe",
  "password": "password123"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Task Management Endpoints

#### Create Task
```http
POST /api/tasks
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "title": "Complete Project Documentation",
  "description": "Write comprehensive documentation for the backend API",
  "status": "TODO",
  "priority": "HIGH",
  "dueDate": "2024-12-31"
}
```

#### Get All Tasks
```http
GET /api/tasks
Authorization: Bearer <jwt-token>
```

#### Get Task by ID
```http
GET /api/tasks/{id}
Authorization: Bearer <jwt-token>
```

#### Update Task
```http
PUT /api/tasks/{id}
Authorization: Bearer <jwt-token>
Content-Type: application/json

{
  "title": "Updated Task Title",
  "description": "Updated description",
  "status": "IN_PROGRESS",
  "priority": "MEDIUM",
  "dueDate": "2024-12-31"
}
```

#### Delete Task
```http
DELETE /api/tasks/{id}
Authorization: Bearer <jwt-token>
```

### API Documentation
Access the interactive API documentation at: `http://localhost:8080/swagger-ui.html`

## 🎯 Usage

### Getting Started
1. **Register a new account** or **login** with existing credentials
2. **Create your first task** using the "Add Task" button
3. **Manage your tasks** by editing, updating status, or deleting them
4. **Track progress** with the visual status indicators

### Task Management
- **Create Tasks**: Add new tasks with title, description, priority, and due date
- **View Tasks**: See all your tasks in an organized list
- **Edit Tasks**: Modify task details at any time
- **Update Status**: Change task status as work progresses
- **Delete Tasks**: Remove completed or unnecessary tasks
- **Filter Tasks**: View tasks by status or priority

### User Interface Features
- **Responsive Design**: Works on all device sizes
- **Real-time Feedback**: Toast notifications for all actions
- **Form Validation**: Prevents invalid data submission
- **Loading States**: Smooth user experience during API calls

## 🧪 Testing

### Backend Testing
```bash
cd backend
mvn test
```

The backend includes:
- **Unit tests** for entities and services
- **Integration tests** for controllers
- **Test containers** for database testing

### Frontend Testing
```bash
cd frontend
npm run test
```

## 🚀 Development

### Backend Development
```bash
cd backend
mvn spring-boot:run
```

### Frontend Development
```bash
cd frontend
npm run dev
```

### Available Scripts

#### Backend
- `mvn clean compile` - Clean and compile the project
- `mvn spring-boot:run` - Run the Spring Boot application
- `mvn test` - Run all tests
- `mvn package` - Create executable JAR file

#### Frontend
- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run lint` - Run ESLint
- `npm run preview` - Preview production build

## 🐳 Deployment

### Backend Deployment
1. **Build the JAR file:**
```bash
cd backend
mvn clean package
```

2. **Run the application:**
```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

### Frontend Deployment
1. **Build for production:**
```bash
cd frontend
npm run build
```

2. **Deploy the `dist` folder** to your web server

### Environment Variables
Set the following environment variables for production:

#### Backend
- `SPRING_DATASOURCE_URL` - Database connection URL
- `SPRING_DATASOURCE_USERNAME` - Database username
- `SPRING_DATASOURCE_PASSWORD` - Database password
- `JWT_SECRET` - JWT signing secret

#### Frontend
- `VITE_API_BASE_URL` - Backend API URL

---

**Built with ❤️ using Spring Boot and React**

For more information, visit the individual README files:
- [Backend Documentation](backend/README.md)
- [Frontend Documentation](frontend/README.md) 