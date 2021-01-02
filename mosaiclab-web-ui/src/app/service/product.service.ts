import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }

  getProducts(pageNumber, pageSize): Observable<any>{
    return this.httpClient.get(environment.baseUrl + environment.api.getProducts, {
      params: {
        pageNumber,
        pageSize
      }
    });
  }

  getDataTableCount(): Observable<any>{
    return this.httpClient.get(environment.baseUrl + environment.api.getDataTableCount);
  }
}
