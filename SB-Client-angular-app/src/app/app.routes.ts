import { Routes } from '@angular/router';
import { StudentListComponent } from './components/student-list/student-list.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { UpdateStudentComponent } from './components/update-student/update-student.component';
import { DepartmentListComponent } from './components/department/department-list/department-list.component';
import { AddDepartmentComponent } from './components/department/add-department/add-department.component';
import { UpdateDepartmentComponent } from './components/department/update-department/update-department.component';


export const routes: Routes = [
  { path: '', redirectTo: '/student-list', pathMatch: 'full' },
  { path: 'student-list', component: StudentListComponent },
  { path: 'add-student', component: AddStudentComponent },
  { path: 'update-student/:id',component:UpdateStudentComponent},
  { path: 'department-list', component: DepartmentListComponent },
  { path: 'save-department', component: AddDepartmentComponent },
  { path: 'update-department/:id', component: UpdateDepartmentComponent },
  { path: '', redirectTo: '/students', pathMatch: 'full' }
];
