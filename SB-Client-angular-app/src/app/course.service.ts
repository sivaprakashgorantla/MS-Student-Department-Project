import { Injectable } from '@angular/core';
import {  Course } from './models/course';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private baseUrl = 'http://localhost:9988/api/course';  
  
  
  constructor(private http: HttpClient) { }
  
  getCourseList(): Observable<any> {
  
    return this.http.get(`${this.baseUrl}`);
  }

  getCourse(id:number):Observable<any>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createCourse(department: Course):Observable<any> {
   return this.http.post(`${this.baseUrl}`, department);
  }

  
  updateCourse(id: number, department: Course): Observable<Object>{
    // return this.http.put(`${this.baseUrl}edit/${id}`, student);
    return this.http.put(`${this.baseUrl}/${id}`, department);
  }

  deleteCourse(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }}
