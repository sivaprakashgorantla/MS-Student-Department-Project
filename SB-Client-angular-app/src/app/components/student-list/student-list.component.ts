import { Component } from '@angular/core';
import { StudentService } from '../../student.service';
import { Student } from '../../student';
import { FormsModule, NgModel } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Observable, of } from 'rxjs';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-student-list',
  standalone: true,
  imports: [CommonModule,RouterLink],
  templateUrl: './student-list.component.html',
  styleUrl: './student-list.component.css'
})
export class StudentListComponent {
  students: Student[] = [];


  // students: Observable<Student[]> = of();

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.loadTable();
  }

loadTable(){
  this.studentService.getStudentList().subscribe({
    next: (response: Student[]) => {
      console.log(response);
      this.students = response;
    },
    error: (error: any) => {

    }

  });
}

  deleteStudent(id: number): void {
    console.log('delete student : '+id);

    this.studentService.deleteStudent(id).subscribe({
      next:(response)=>{
this.loadTable();
      },
      error:(error)=>{

      }
    });
    // this.students = this.studentService.getStudents();
  }

  // updateStudent(id: number): void {
  //   // this.studentService.updateStudent(id,{ firstName: this.}).subscribe({
  //   //   next:(response)=>{

  //   //   },
  //   //   error:(error)=>{

  //   //   }

  //   // });
  //   // this.students = this.studentService.getStudents();
  // }

}
