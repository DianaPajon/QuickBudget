# QuickBudget Roadmap


## Current week plans


_(updated 2022-05-30)_

### Objectives:
   - Complete the data model.
   - Try to implement a mock cordova server that communicates with a spring boot app over wifi. Start building from theere.

## Development blog 

_(latest post first)_

### 2022-05-30 19:16: Motivation and idea.

Hi everyone. This is the first entry. The idea behind this blog is to keep track of the project evolution. 
From the initial idea to its (hopeful) completion .

Let me introduce myself. My name is Diana, I'm 36 and I'm a programmer. Been programming for a long time, mostly as a hired developer. 
The thing is, since I worked mostly for other people, I don't own most of the code I've written, and I have little to show on a job interview. 
I've been wanting to change that, so I started this project. 
Also, I'm a little fast when spending money, and though I don't have any financial troubles, I will if i dont start controlling my expenses. 
So, I'm killing two birds with one stone here.
I'm sure this idea has been done before. I'm not gonna look it up on the web, but it's not hard to imagine.

The main idea of this app is to have a full picture every whenever I want to spend money. 
To that point, the interface of this app must show a breakdown whenever a new expense is added. There are some caveats:
  - I live in Argentina, we have a bimonetary economy. I get my salary in argentine pesos, but i spend dollars often. 
    Argentine peso is unstable, so let's say i buy something with my credit card, I't will paid at the closing date using the exchange rate at that time.
  - I use credit cards / virtual wallets that let me pay on many installments, so I have to keep track of every installment, 
    and the total debt itself is also important
  - I want to **control** my expenses, wich means I must be able to set objectives.

#### The application

##### Data model

The first thing is the data model. I want at least two accounts, one for pesos and one for dollars. However, it won't be fixed, I could travel somewhere
and have to take into account a new currency, so that option must exist. There will be two ways to modify the account. One is by adding a source of income.
These could be one-time income, or a recurrent income, like a salary. As for expenses, these could be one-time immediate expenses, recurrent expenses or 
payment installments. Expenses must have an article associated with it, wich can be categorized, later, categories can be summarized.

The app will also have a "shopping list" option, wich can be used whenever I'm shopping for many articles. If I use that option, the expense will be shown as a single
expense, but each individual article will be summarized on its corresponding category.

Expenses can go into different "wallets", like credit cards or virtual wallets, and the application can show a summary of any specific wallet. 

Finally, the user can set objectives. These objectives can we used later when showing metrics. 
These could be things like "i want to spend XXXX on food this month" or "i want to save at least XXXX pesos". 
The objectives can have a bottom limit and a top limit.

##### Technical aspects

I'm currently hired as a full stack spring/angular/serverless nodejs developer. I want this project finished, so I will
use angular for the frontend and spring boot for the backend. Also, I will use cordova to complete it as a mobile app.

The app can work offline, but it can synchronize itself with a server. It's not hard to do, since It is a personal budget app, so there will be only one
person using any specific budget at the time. However, it will support many users, each one with its individual login.

The first project so far will be a java model for the data model. After that I will implement a spring boot project for the backend. It will include a user token field wich will
be hardcoded, later login will be implemented.

As for the frontend, it will be an angular project. Further details will be specified later.

The project will complete itself with an cordova project, that will implement everything the frontend needs to work offline, and will also synchronize itself with the backend.

Initially, it will run un a local server, the front end will synchronize itself over wifi only.

##### Timeline.

I will  try to spend 5 hours every week on this project. If more time is used it will be specified. The total time will be tracked somehow. 
