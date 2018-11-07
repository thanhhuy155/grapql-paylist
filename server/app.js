const express = require('express');
const graphqlHTTP = require('express-graphql');
const schema = require('./schema/schema');


// Allow cors

const cors = require('cors');



// install 
const app = express();
//Run project = : nodemom app
//Install mongoos: npm install mongoose
const mongoose = require('mongoose');
app.use(cors());
// connect to the mlab database
// replace username + pass 
mongoose.connect('mongodb://harrison:Vimotnguoi1@ds253243.mlab.com:53243/gql-ninja');
mongoose.connection.once('open', () => {
    console.log('connect to database');
})

app.use('/graphql',graphqlHTTP({
    schema: schema,
    graphiql: true
}));
app.listen(4000,()=>{
    console.log('Now listen on port 4000');
})