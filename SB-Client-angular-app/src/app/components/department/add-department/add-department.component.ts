import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule, FormGroup, FormControl, Validators } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { Student } from '../../../models/Student';
import { StudentService } from '../../../student.service';
import { StudentListComponent } from '../../student/student-list/student-list.component';
import { Department } from '../../../models/department';
import { DepartmentService } from '../../../department.service';

@Component({
  selector: 'app-add-department',
  standalone: true,
  imports: [StudentListComponent, FormsModule, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './add-department.component.html',
  styleUrl: './add-department.component.css'
})
export class AddDepartmentComponent {

  department: Department = {
    departmentId: 0,
    departmentName: '',
    departmentAddress: '',
    departmentCode: ''
  };

  submitted = false;

  ngOnInit() {
    this.submitted = false;
  }

  constructor(private departmentService: DepartmentService, private router: Router) { }


  saveDepartment(): void {
    console.log(this.departmentSaveForm);

    this.departmentService.createDepartment({
      departmentId: 122201,
      departmentName: this.departmentSaveForm.value.departmentName!,
      departmentAddress: this.departmentSaveForm.value.departmentAddress!,
      departmentCode: this.departmentSaveForm.value.departmentCode!,
    }).subscribe(
      {
        next: (response: any) => {
          this.router.navigateByUrl('/department-list');
        },
        error: (error: any) => {
          console.log(error);
        }
      }


    )

    this.resetForm();
  }

  resetForm(): void {
    this.department = { departmentId: 0, departmentName: '', departmentAddress: '', departmentCode: '' };
  }

  addDepartmentForm() {
    this.submitted = false;
    this.departmentSaveForm.reset();

  }

  departmentSaveForm = new FormGroup({
    departmentName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    departmentAddress: new FormControl('', [Validators.required, Validators.minLength(5)]),
    departmentCode: new FormControl('', [Validators.required, Validators.email]),
    student_branch: new FormControl()
  });

}
