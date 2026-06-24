import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

export interface MarketplaceStatus {
  product: string;
  phase: string;
  stack: string[];
  capabilities: string[];
}

export interface CategorySummary {
  slug: string;
  name: string;
  priority: number;
  launchShare: number;
}

@Injectable({ providedIn: 'root' })
export class MarketplaceApi {
  private readonly http = inject(HttpClient);
  private readonly baseUrl = environment.apiBaseUrl;

  getStatus(): Observable<MarketplaceStatus> {
    return this.http.get<MarketplaceStatus>(`${this.baseUrl}/status`);
  }

  getCategories(): Observable<CategorySummary[]> {
    return this.http.get<CategorySummary[]>(`${this.baseUrl}/categories`);
  }
}
