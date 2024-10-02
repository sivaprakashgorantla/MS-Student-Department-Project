import { Routes } from '@angular/router';
import { AddStudentComponent } from './components/student/add-student/add-student.component';
import { DepartmentListComponent } from './components/department/department-list/department-list.component';
import { AddDepartmentComponent } from './components/department/add-department/add-department.component';
import { UpdateDepartmentComponent } from './components/department/update-department/update-department.component';
import { StudentListComponent } from './components/student/student-list/student-list.component';
import { UpdateStudentComponent } from './components/student/update-student/update-student.component';
import { CourseListComponent } from './components/course/course-list/course-list.component';
import { UpdateCourseComponent } from './components/course/update-course/update-course.component';
import { AddCourseComponent } from './components/course/add-course/add-course.component';


export const routes: Routes = [
  { path: '', redirectTo: '/student-list', pathMatch: 'full' },
  { path: 'student-list', component: StudentListComponent },
  { path: 'add-student', component: AddStudentComponent },
  { path: 'update-student/:id',component:UpdateStudentComponent},

  { path: 'department-list', component: DepartmentListComponent },
  { path: 'save-department', component: AddDepartmentComponent },
  { path: 'update-department/:id', component: UpdateDepartmentComponent },
  
  { path: 'course-list', component: CourseListComponent },
  { path: 'update-course/:id', component: UpdateCourseComponent },
  { path: 'save-course', component: AddCourseComponent },
  { path: '', redirectTo: '/students', pathMatch: 'full' }
];
