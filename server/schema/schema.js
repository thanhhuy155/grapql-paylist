const graphql = require('graphql');
const _ = require('lodash');
const { GraphQLObjectType, GraphQLString, GraphQLSchema, GraphQLInt,GraphQLList, GraphQLID, GraphQLNonNull} = graphql;

const Book = require('../models/book');
const Author = require('../models/author');


// // dummy data
// var books = [
//     {id: 1, name: 'Harrison',genre: 'Fan', authorID: 1},
//     {id: 2, name: 'Harrison 1 ',genre: 'vcbcv', authorID: 1 },
//     {id: 3, name: 'Harrison',genre: '32132 ', authorID: 2},
// ];

// var authors = [
    
//     { id: 1, name: 'Harrison 1 ',age: 22, },
//     { id: 2, name: 'Harrison 2 ',age: 21, },
//     { id: 3, name: 'Harrison 3 ',age: 11, }
    
// ];

const BookType = new GraphQLObjectType({
    name: 'Book',
    fields: () => ({
        id: {type: GraphQLID},
        name: {type: GraphQLString},
        genre: {type: GraphQLString},
        author: {
            type: AuthorType,
            resolve(parent, args) {
                console.log(parent);
                //return _.find(authors, {id: parent.authorID});
                return Author.findById(parent.authorID);
            }
        }
    })
});
// Tim sach cua tac gia nao thi dung find.
// Tim 1 tac gia co bao nhieu book thi dung filter
const AuthorType = new GraphQLObjectType({
    name: 'Author',
    fields: () => ({
        id: {type: GraphQLID},
        name: {type: GraphQLString},
        age: {type: GraphQLInt},
        books:{
            type: new GraphQLList(BookType),
            resolve(parent,args) {
                //console.log(parent);
                //return _.filter(books, {authorID: parent.id}); // Filter trong book, authorID: trùng với parent.id
                //Tim kiem toan bo sach, nen dung Find() va {}
                return Book.find({authorID: parent.id})
            }

        }
    })
});

const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    fields: {
        book: {
            type: BookType,
            args: {
                id: {
                    type: GraphQLID
                }
            },
            resolve(parent, args) {
                // code to get the database. 
                // return _.find(books, {
                //     id: args.id
                // });
                return Book.findById(args.id)
            }

        },
        author: {
            type: AuthorType,
            args: {id: {type: GraphQLID}},
            resolve(parent, args) {
                //return _.find(authors, {id: args.id});
                return Author.findById(args.id);
            }
        },
        books: {
            type: new GraphQLList(BookType),
            resolve(parent,args){
               // return books;
               return Book.find({});
            }
        },
        authors: {
            type: new GraphQLList(AuthorType),
            resolve(parent,args){
                //return authors;
                return Author.find({})

            }
        }

    }
});


// Mutation de tao, them xoa data
const Mutation = new GraphQLObjectType({
    name: 'Mutation',
    fields: {
        addAuthor: {
            type: AuthorType,
            args: {
                name: {type: new GraphQLNonNull (GraphQLString)},
                age: { type: new GraphQLNonNull (GraphQLInt)}
            },
            resolve(parent, args){
                let author = new Author({
                    name: args.name,
                    age: args.age
                });
                //can Return ve
                 return author.save();
            }
        },
        addBook: {
            type: BookType,
            args: {
                name: {type: new GraphQLNonNull(GraphQLString)},
                genre: {type: new GraphQLNonNull(GraphQLString)},
                authorID: {type: new GraphQLNonNull(GraphQLID)}
            },
            resolve(parent,args){
                let book = new Book({
                    name: args.name,
                    genre: args.genre,
                    authorID: args.authorID
                });
                return book.save();
            } 
        }
    }
})



// book(id:"2"){
//     name
//     genre
// };
module.exports = new GraphQLSchema({
    query: RootQuery,
    mutation: Mutation
});