import {ChangeDetectorRef, Component, OnDestroy, OnInit} from '@angular/core';
import {ProductService} from './service/product.service';
import {Subject} from 'rxjs';
import {takeUntil} from 'rxjs/operators';
import {Product} from './model/product';
import {LazyLoadEvent} from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy{
  unsubscribeSubject: Subject<any> = new Subject<any>();
  products: Product[];
  totalRecords: number;
  loading: boolean;
  rows = 10;

  constructor(private productService: ProductService, private cdr: ChangeDetectorRef) {
  }
  ngOnInit(): void {
    this.productService.getDataTableCount().
      pipe(takeUntil(this.unsubscribeSubject)).
      subscribe((data) => {
        this.totalRecords = data.totalItems;
    });
    this.loading = true;
    this.cdr.detectChanges();
  }


  loadProducts(event: LazyLoadEvent) {
    this.rows = event.rows;
    const pageNumber = event.first / this.rows;
    this.productService.getProducts(pageNumber, this.rows).
    pipe(takeUntil(this.unsubscribeSubject)).subscribe((data) => {
      this.products = data;
    });
    this.loading = false;
  }

  ngOnDestroy(): void {
    this.unsubscribeSubject.next();
    this.unsubscribeSubject.unsubscribe();
  }
}
