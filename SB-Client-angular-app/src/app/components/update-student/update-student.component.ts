import { Component } from '@angular/core';
import { Student } from '../../student';
import { StudentService } from '../../student.service';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-student',
  standalone: true,
  imports: [UpdateStudentComponent, FormsModule, ReactiveFormsModule, CommonModule, RouterModule],
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.css'
})
export class UpdateStudentComponent {

  student: any;

  
  constructor(private studentService: StudentService, private activatedroute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    let id = this.activatedroute.snapshot.params['id'];
    console.log(id);

    this.studentService.getStudent(id).subscribe({
      next: (response) => {
        console.log(response);
        this.student = response;
        this.studentsaveform.controls['firstName'].setValue(response.firstName);
        this.studentsaveform.controls['lastName'].setValue(response.lastName);
        this.studentsaveform.controls['email'].setValue(response.email);
      },
      error: (error: any) => {

      }

    });
  }

  studentsaveform = new FormGroup({
    firstName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    lastName: new FormControl('', [Validators.required, Validators.minLength(5)]),
    email: new FormControl('', [Validators.required, Validators.email]),
    student_branch: new FormControl()
  });

  updateStudent(): void {
    let id = this.activatedroute.snapshot.params['id']
    console.log(this.studentsaveform);

    this.studentService.updateStudent(id,{
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
}
