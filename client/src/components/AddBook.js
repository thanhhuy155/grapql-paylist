import React, { Component } from 'react';
import { gql } from 'apollo-boost';
import { graphql } from 'react-apollo';

const getAuthorsQuery = gql`
    {
        authors {
            name
            id
        }
    }
`
class AddBook extends Component {
    displayAuthors(){
        var data = this.props.data;
        if(data.loading){
            return (<option disabled>Loading authors....</option>)
        }
        else{
            return data.authors.map(author => {
                return (<option key = {author.id} value = {author.id}>{author.name}</option>)
            })
        }
    }
    render() {
        // console.log(this.props)
      return (
        <form id="add-book">
         <div className="field">
        <label >Book name: </label>
        <input type="text" name="" id=""/>>
         </div>
    <div className="field">
        <label >Genre: </label>
        <input type="text" name="" id=""/>
    </div>
    <div className="field">
        <label >Book name: </label>
        <select name="" id="">
            <option value="">Select author</option>
            {this.displayAuthors()}
        </select>
    </div>
    <button> + </button>
        </form>
      );
    }
  }
  export default graphql(getAuthorsQuery)(AddBook)