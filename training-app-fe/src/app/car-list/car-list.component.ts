import { CarDetailsComponent } from '../car-details/car-details.component';
import { Observable } from "rxjs";
import { CarService } from "../_services/car-service/car.service";
import { Car } from "../_models/car";
import { Component, OnInit } from "@angular/core";
import { Router } from '@angular/router';

@Component({
  selector: "app-car-list",
  templateUrl: "./car-list.component.html",
  styleUrls: ["./car-list.component.css"]
})
export class CarListComponent implements OnInit {
  cars: Observable<Car[]> | undefined;

  constructor(private carService: CarService,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.cars = this.carService.getCarsList();
  }

  deleteCar(id: number) {
    this.carService.deleteCar(id)
      .subscribe(
        (data: any) => {
          console.log(data);
          this.reloadData();
        },
        (error: any) => console.log(error));
  }

  carDetails(id: number){
    this.router.navigate(['details', id]);
  }
}