import { Injectable } from '@angular/core';
import { Department } from './department';
import { Observable } from 'rxjs/internal/Observable';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {
  
  private baseUrl = 'http://localhost:9988/api/department/';  
  
  
  constructor(private http: HttpClient) { }
  
  getDepartmentList(): Observable<any> {
  
    return this.http.get(`${this.baseUrl}`);
  }

  getDepartment(id:number):Observable<any>{
    return this.http.get(`${this.baseUrl}${id}`);
  }

  createDepartment(department: Department):Observable<any> {
   return this.http.post(`${this.baseUrl}`, department);
  }

  
  updateDepartment(id: number, department: Department): Observable<Object>{
    // return this.http.put(`${this.baseUrl}edit/${id}`, student);
    return this.http.put(`${this.baseUrl}${id}`, department);
  }

  deleteDepartment(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}${id}`);
  }
}

