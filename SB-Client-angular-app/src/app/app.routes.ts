import { Routes } from '@angular/router';
import { StudentListComponent } from './components/student-list/student-list.component';
import { AddStudentComponent } from './components/add-student/add-student.component';
import { UpdateStudentComponent } from './components/update-student/update-student.component';
import { DepartmentListComponent } from './components/department/department-list/department-list.component';
import { AddDepartmentComponent } from './components/department/add-department/add-department.component';
import { UpdateDepartmentComponent } from './components/department/update-department/update-department.component';
import { ClassListComponent } from './components/class/class-list/class-list.component';
import { UpdateClassComponent } from './components/class/update-class/update-class.component';


export const routes: Routes = [
  { path: '', redirectTo: '/student-list', pathMatch: 'full' },
  { path: 'student-list', component: StudentListComponent },
  { path: 'add-student', component: AddStudentComponent },
  { path: 'update-student/:id',component:UpdateStudentComponent},
  { path: 'department-list', component: DepartmentListComponent },
  { path: 'save-department', component: AddDepartmentComponent },
  { path: 'update-department/:id', component: UpdateDepartmentComponent },
  { path: 'class-list', component: ClassListComponent },
  { path: 'update-class/:id', component: UpdateClassComponent },
  { path: '', redirectTo: '/students', pathMatch: 'full' }
];
