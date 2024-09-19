import { Injectable } from '@angular/core';
import { Department } from './department';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  
  private baseUrl = 'http://localhost:8080/api/';  
  
  private deparments:Department[]=[
    {departmentId:2001,departmentName:'Production',departmentAddress:'Product',departmentCode:'PRODC01'},
    {departmentId:2002,departmentName:'Marketing',departmentAddress:'Super Market',departmentCode:'SMC01'},
    {departmentId:2003,departmentName:'Develpment',departmentAddress:'Vivil',departmentCode:'DCC01'},
    {departmentId:2004,departmentName:'Sales',departmentAddress:'Mobile, Telivision',departmentCode:'SAC01'},
    {departmentId:2005,departmentName:'SOFTWARE',departmentAddress:'JAVA, .NET',departmentCode:'IT01'},
    ]
  constructor() { }

  getStudents(): Department[]{
    return this.deparments;
  }

  getDepartment(id:number):Department | undefined{
    return this.deparments.find(d=> d.departmentId === id);
  }

  addDepartment(department: Department):void {
    this.deparments.push(department);
  }

  updateDepartment(updateDepartment:Department):void{
    const index = this.deparments.findIndex(d => d.departmentId === updateDepartment.departmentId);
    if (index !== -1) {
      this.deparments[index] = updateDepartment;
    }
  }

  deleteDepartment(id: number): void {
    this.deparments = this.deparments.filter(d => d.departmentId !== id);
  }
}

