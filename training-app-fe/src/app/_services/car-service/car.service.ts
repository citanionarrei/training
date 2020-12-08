import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8080/api/cars';

  constructor(private httpClient: HttpClient) { }



public getAllCars(): Observable<any>{
return this.httpClient.get(environment.API_URL+ "api/cars");
}

getCar(id: number): Observable<any> {
  return this.httpClient.get(`${this.baseUrl}/${id}`);
}

createCar(car: Object): Observable<Object> {
  return this.httpClient.post(`${this.baseUrl}`, car);
}

updateCar(id: number, value: any): Observable<Object> {
  return this.httpClient.put(`${this.baseUrl}/${id}`, value);
}

deleteCar(id: number): Observable<any> {
  return this.httpClient.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
}

getCarsList(): Observable<any> {
  return this.httpClient.get(`${this.baseUrl}`);
}
}

