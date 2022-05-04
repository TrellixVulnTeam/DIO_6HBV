import { Book } from './product-list/model/book';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private url = 'http://localhost:8080/books';

  httpOptions = {
     Headers: new HttpHeaders({'content-type': 'application/json'})
  }

  constructor(private http: HttpClient) { }

   getBook(): Observable<Book[]>  {
     return this.http.get<Book[]>(this.url);
   }


}
