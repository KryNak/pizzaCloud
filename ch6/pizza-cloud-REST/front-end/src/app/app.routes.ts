import {Routes} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import {RecentsComponent} from './components/recents/recents.component';
import {SpecialsComponent} from './components/specials/specials.component';
import {LocationsComponent} from './components/locations/locations.component';
import {DesignComponent} from './components/design/design.component';
import {CartComponent} from './components/cart/cart.component';


export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'recents',
    component: RecentsComponent
  },
  {
    path: 'specials',
    component: SpecialsComponent
  },
  {
    path: 'locations',
    component: LocationsComponent
  },
  {
    path: 'design',
    component: DesignComponent
  },
  {
    path: 'cart',
    component: CartComponent
  },
  {
    path: '**',
    redirectTo: 'home',
    pathMatch: 'full'
  }
];
