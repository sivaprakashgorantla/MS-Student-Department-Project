import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Department } from '../department';
import { DepartmentService } from '../department.service';

@Component({
  selector: 'app-add-department',
  standalone: true,
  imports: [],
  templateUrl: './add-department.component.html',
  styleUrl: './add-department.component.css'
})
export class AddDepartmentComponent implements OnInit {

  department: Department = {
    departmentId: 0,
    departmentName: '',
    departmentAddress: '',
    departmentCode: ''
  };

  submitted = false;  

  ngOnInit() {  
    this.submitted=false;  
  }  

  constructor(private studentService: DepartmentService) {}


  saveStudent(): void {
    console.log(this.studentsaveform);
    this.studentService.addDepartment(
      {
        departmentName:this.studentsaveform.value.departmentName!,
        departmentAddress:this.studentsaveform.value.departmentAddress!,
        departmentCode:this.studentsaveform.value.departmentCode!,

      }
    );
    this.resetForm();
  }

  resetForm(): void {
    this.department = { departmentId: 0, departmentName: '', departmentAddress: '', departmentCode: '' };
  }

  addStudentForm(){  
    this.submitted=false;  
    this.studentsaveform.reset();  
  }
  
  studentsaveform=new FormGroup({  
    departmentName:new FormControl('' , [Validators.required , Validators.minLength(5) ] ), 
    departmentAddress:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
    departmentCode:new FormControl('',[Validators.required,Validators.minLength(5) ]),  
    student_branch:new FormControl()  
  });  
}

