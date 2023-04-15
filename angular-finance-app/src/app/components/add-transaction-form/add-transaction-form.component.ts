import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Transaction } from 'src/app/models/transaction';

@Component({
  selector: 'app-add-transaction-form',
  templateUrl: './add-transaction-form.component.html',
  styleUrls: ['./add-transaction-form.component.scss']
})
export class AddTransactionFormComponent implements OnInit {

  transactionForm!: FormGroup;

  transactions: Transaction[] = [
    new Transaction(new Date("2023-04-14"), "Amazon", "Shopping", 100),
    new Transaction(new Date("2023-04-13"), "Starbucks", "Food and Drinks", 5.75),
    new Transaction(new Date("2023-04-12"), "Target", "Shopping", 50.99),
  ];

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.transactionForm = this.fb.group({
      date: [new Date().toISOString().substr(0, 10), Validators.required],
      merchant: ['', Validators.required],
      category: ['Misc', Validators.required],
      amount: ['', Validators.required],
    });
  }

  onSubmit() {
    const { date, merchant, category, amount } = this.transactionForm.value;
    const newTransaction = new Transaction(new Date(date), merchant, category, amount);
    this.transactions.push(newTransaction);
    this.transactionForm.reset();

    this.transactionForm.patchValue({
      date: new Date().toISOString().substr(0, 10), // set date back to today's date
      merchant: '',
      category: 'Misc',
      amount: '',
    });

    
    const merchantInput = document.querySelector('input[name="merchant"]') as HTMLInputElement;
    merchantInput.focus(); // set focus to merchant field

  }

}
