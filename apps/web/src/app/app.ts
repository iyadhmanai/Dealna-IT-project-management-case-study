import { AsyncPipe } from '@angular/common';
import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MarketplaceApi } from './core/api/marketplace-api';

@Component({
  selector: 'app-root',
  imports: [AsyncPipe, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
  private readonly marketplaceApi = inject(MarketplaceApi);

  protected readonly status$ = this.marketplaceApi.getStatus();
  protected readonly categories$ = this.marketplaceApi.getCategories();
}
