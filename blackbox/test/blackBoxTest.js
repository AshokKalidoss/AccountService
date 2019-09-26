//During the test the env variable is set to test
process.env.NODE_ENV = 'dev';

let chai = require('chai');
let chaiHttp = require('chai-http');
let should = chai.should();
const http = require('http')
const { expect } = require('chai')
chai.use(chaiHttp);

  describe('/GET Accounts success', () => {
           it('retrieves accounts for valid userId, as expected', function(done) {
                 chai.request('http://localhost:8080')
                 .get('/api/v1/users/1001/accounts')
                 .end(function(err, res) {
                   expect(res).to.have.status(200);
                   done();
                 });
               });

       });


  describe('/GET Accounts Validation', () => {
            it('throws Bad Request response when userId is invalid, as expected', function(done) {
                   chai.request('http://localhost:8080')
                   .get('/api/v1/users/10010000000/accounts')
                   .end(function(err, res) {
                     expect(res).to.have.status(400);
                     done();
                   });
                 });

         });


  describe('/GET Accounts Not Found', () => {
             it('throws Not Found response when userId does not have associated accounts, as expected', function(done) {
                      chai.request('http://localhost:8080')
                      .get('/api/v1/users/10010/accounts')
                      .end(function(err, res) {
                        expect(res).to.have.status(404);
                        done();
                      });
                    });

            });

  describe('/GET Transactions success', () => {
           it('retrieves transactions for valid account number, as expected', function(done) {
                 chai.request('http://localhost:8080')
                 .get('/api/v1/accounts/10011001/transactions')
                 .end(function(err, res) {
                   expect(res).to.have.status(200);
                   done();
                 });
               });

       });


  describe('/GET Transactions Validation', () => {
            it('throws Bad Request response when account number is invalid, as expected', function(done) {
                   chai.request('http://localhost:8080')
                   .get('/api/v1/accounts/ABC/transactions')
                   .end(function(err, res) {
                     expect(res).to.have.status(400);
                     done();
                   });
                 });

         });


  describe('/GET Transactions Not Found', () => {
             it('throws Not Found response when account number does not have associated transactions, as expected', function(done) { // <= Pass in done callback
                      chai.request('http://localhost:8080')
                      .get('/api/v1/accounts/1001100101-01/transactions')
                      .end(function(err, res) {
                        expect(res).to.have.status(404);
                        done();
                      });
                    });

            });
