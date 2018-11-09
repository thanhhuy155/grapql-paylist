import React, { Component } from 'react';

import { graphql, compose   } from 'react-apollo';
import { getAuthorsQuery, addBookMutation} from '../queries/queries';

class AddBook extends Component {
    constructor(props){
        super(props);
        this.state = {
            name: '',
            genre: '',
            authorID:''
        }
    }
    displayAuthors(){
       // var data = this.props.data; bi loi do data 
       var data = this.props.getAuthorsQuery;
    //    console.log(this.props);
        if(data.loading){
            return (<option disabled>Loading authors....</option>)
        }
        else{
            return data.authors.map(author => {
                return (<option key = {author.id} value = {author.id}>{author.name}</option>)
            })
        }
    }
    submitForm(e){
        e.preventDefault();
        // console.log(this.state);
        this.props.addBookMutation({
            variables:{
                name: this.state.name,
                genre: this.state.genre,
                authorID: this.state.authorID
            }
        });
    }
    render() {
        // console.log(this.props)
      return (
        <form id="add-book" onSubmit = {this.submitForm.bind(this)}>
         <div className="field">
        <label >Book name: </label>
        <input type="text" name="" id="" onChange= {(e) => this.setState({name: e.target.value}) }/>
         </div>
    <div className="field">
        <label >Genre: </label>
        <input type="text" name="" id=""  onChange= {(e) => this.setState({genre: e.target.value}) } />
    </div>
    <div className="field">
        <label >Book name: </label>
        <select name="" id=""  onChange= {(e) => this.setState({authorID: e.target.value}) }>
            <option value="">Select author</option>
            {this.displayAuthors()}
        </select>
    </div>
    <button> + </button>
        </form>
      );
    }
  }
  export default compose(
      graphql(getAuthorsQuery,{name:"getAuthorsQuery"}),
      graphql(addBookMutation, {name:"addBookMutation"})
  )(AddBook)