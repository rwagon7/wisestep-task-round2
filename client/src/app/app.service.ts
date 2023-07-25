import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject, skip } from 'rxjs';
import { reqAndResEntity } from "./url";
import { HttpClient } from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private Http: HttpClient) { }


  urlShortner(payload: String): Observable<any> {
    return this.Http.post("http://localhost:8080/save", payload, { responseType: 'text', observe: 'response' });
  }

}
