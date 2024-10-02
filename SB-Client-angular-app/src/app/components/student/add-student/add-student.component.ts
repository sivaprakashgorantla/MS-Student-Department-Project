import { Component, OnInit } from '@angular/core';
import { StudentListComponent } from "../student-list/student-list.component";
import { Student } from '../../../models/Student';
import { StudentService } from '../../../student.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-add-student',
  standalone: true,
  imports: [StudentListComponent, FormsModule, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './add-student.component.html',
  styleUrl: './add-student.component.css'
})
export class AddStudentComponent implements OnInit {

  student: Student = {
    studentId: 0,
    firstName: '',
    lastName: '',
    email: ''
  };

  submitted = false;

  ngOnInit() {
    this.submitted = false;
  }

  constructor(private studentService: StudentService, private router: Router) { }


  saveStudent(): void {
    console.log(this.studentsaveform);

    this.studentService.createStudent({
      studentId: 122201,
      firstName: this.studentsaveform.value.firstName!,
      lastName: this.studentsaveform.value.lastName!,
      email: this.studentsaveform.value.email!,
    }).subscribe(
      {
        next: (response: any) => {
          this.router.navigateByUrl('/student-list');
        },
        error: (error: any) => {
          console.log(error);
        }
      }


    )

    this.resetForm();
  }

  resetForm(): void {
    this.student = { studentId: 0, firstName: '', lastName: '', email: '' };
  }

  addStudentForm() {
    this.submitted = false;
    this.studentsaveform.reset();

  }

  studentsaveform = new FormGroup({
    firstName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    lastName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    student_branch: new FormControl()
  });
}
