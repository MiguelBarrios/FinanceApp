export class Transaction {
    date: Date;
    merchant: string;
    category: string;
    amount: number;
  
    constructor(date: Date, merchant: string, category: string, amount: number) {
      this.date = date;
      this.merchant = merchant;
      this.category = category;
      this.amount = amount;
    }
}
