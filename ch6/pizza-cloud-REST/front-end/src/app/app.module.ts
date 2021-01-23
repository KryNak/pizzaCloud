import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { routes } from './app.routes';
import { ApiComponent } from './components/api/api.component';
import { BigButtonComponent } from './components/big-button/big-button.component';
import { CartComponent } from './components/cart/cart.component';
import { CloudTitleComponent } from './components/cloud-title/cloud-title.component';
import { DesignComponent } from './components/design/design.component';
import { FooterComponent } from './components/footer/footer.component';
import { GroupBoxComponent } from './components/group-box/group-box.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { LittleButtonComponent } from './components/little-button/little-button.component';
import { LocationsComponent } from './components/locations/locations.component';
import { LoginComponent } from './components/login/login.component';
import { RecentsComponent } from './components/recents/recents.component';
import { SpecialsComponent } from './components/specials/specials.component';

import { CartService } from './services/cart/cart.service';

@NgModule({
  declarations: [
    AppComponent,
    ApiComponent,
    BigButtonComponent,
    CartComponent,
    CloudTitleComponent,
    DesignComponent,
    FooterComponent,
    GroupBoxComponent,
    HeaderComponent,
    HomeComponent,
    LittleButtonComponent,
    LocationsComponent,
    LoginComponent,
    RecentsComponent,
    SpecialsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    CartService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
