import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {CartService} from '../../services/cart/cart.service';

@Component({
  selector: 'app-design',
  templateUrl: './design.component.html',
  styleUrls: ['./design.component.css']
})

export class DesignComponent implements OnInit {

  model = {
    name: '',
    ingredients: []
  };

  allIngredients: any;
  pizzasDough = [];
  proteins = [];
  veggies = [];
  cheeses = [];
  sauces = [];

  constructor(private httpClient: HttpClient, private router: Router, private cart: CartService) {
  }
  ngOnInit(): void {
    this.httpClient.get('http://localhost:8080/ingredientsx')
      .subscribe(data => {
        this.allIngredients = data;
        this.pizzasDough = this.allIngredients.filter(d => d.type === 'PIZZA_DOUGH');
        this.proteins = this.allIngredients.filter(p => p.type === 'PROTEIN');
        this.veggies = this.allIngredients.filter(v => v.type === 'VEGGIES');
        this.cheeses = this.allIngredients.filter(c => c.type === 'CHEESE');
        this.sauces = this.allIngredients.filter(s => s.type === 'SAUCE');
      });
  }
  updateIngredients(ingredient, event): void {
    if (event.target.checked) {
      this.model.ingredients.push(ingredient);
    } else {
      this.model.ingredients.splice(this.model.ingredients.findIndex(i => i === ingredient), 1);
    }
  }
  onSubmit(): void {
    this.httpClient.post(
      'http://localhost:8080/design',
      this.model, {
        headers: new HttpHeaders().set('Content-type', 'application/json'),
      }).subscribe(taco => this.cart.addToCart(taco));

    this.router.navigate(['/cart']);
  }

}