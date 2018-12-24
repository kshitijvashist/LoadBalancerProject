import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import DSSS from './Component/comp1'



class App extends Component {
  state = { show: false };

  showModal = () => {
    this.setState({ show: true });
  };

  hideModal = () => {
    this.setState({ show: false });
  };
  
  constructor(props){
    super(props);
    this.state={
      items:[],
      isLoaded:false,

    }
  }

  componentDidMount()
  {
   
    fetch('http://localhost:8080/employee/get')
    .then(res=>res.json())
    .then(json=>{

      this.setState({
        isLoaded:true,
items:json

      })
    });
  }
  render() {
    var {isLoaded,items}=this.state;
    return (
      <div className="App"> 
    
    <h1>Employee Management</h1>
     
    
      <table border="1">
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Age</th>
          <th>Salary</th>

        </tr>
       
        {items.map(item=>(
           <tr>
          <td >
          {item.empNo}</td>
          
          <td>{item.empName}</td>

          <td>{item.empAge}</td>

          <td>{item.empSal}</td>

          <td><input type="button" value="Edit" class="button" /></td>

          <td> <input type="button" value="Delete" class="button"/></td>
          </tr>
          
         

        ))}
        <tr><input type="button" value="Create" name="Create" onClick={this.showModal} /></tr>
        </table>
      </div>
    );
   
   
  }
}

export default App;
