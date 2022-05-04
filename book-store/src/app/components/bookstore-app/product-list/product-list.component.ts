import { Book } from './model/book';
import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  livros: Book[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.listBooks();
  }

  listBooks(){
    this.productService.getBook().subscribe(retorno => {
        this.livros = retorno;

       }
      );
  }



}
