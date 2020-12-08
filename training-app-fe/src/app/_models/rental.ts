export class Rental
{
public id:number;
public startData: string;
public releaseData: string;
public client: number;
public car: number;


constructor(id:number, startData:string, releaseData:string , client:number, car:number){
this.id = id;
this.startData = startData;
this.releaseData = releaseData;
this.client = client;
this.car = car;
 }
}