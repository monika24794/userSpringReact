import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useNavigate } from 'react-router-dom';


export default function Read() {
  const navigate = useNavigate();
  const[users, setUsers]=useState([]);


  const getUsers=() =>{
    axios.get(`http://localhost:9595/user/add`)
    .then(response => {
      console.log(response.data);
      setUsers(response.data);
    }).catch((error)=> {
      console.log(error);
    })
  }
  
  const handleRegister = () =>{
    navigate("/create")

  }
  const handleLocalStrorage = (id,name,userName,password) =>{
  // console.log(id.name,userName,password)
  localStorage.setItem("id", id);
  localStorage.setItem("name", name);
  localStorage.setItem("userName", userName);
  localStorage.setItem("password",password);
  }
  useEffect(() =>{
    getUsers();
  },[]);

  return (
    <>
    <div className="container mt-3 mb-3">
      <button className='btn btn-info m-2' onClick={handleRegister}>Register</button>
      <h3>Users</h3>
      <div className="row mt-3 mb-3">
      <table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Username</th>
      <th scope="col">Password</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
  <tbody>
    {
      users.map((user) =>{
        return (
        <tr>
          <td>{user.id}</td>
          <td>{user.name}</td>
          <td>{user.userName}</td>
          <td>{user.password}</td>

          <td>
            <Link to="/update">
            <button className='btn btn-success' onClick={()=>handleLocalStrorage(user.id,user.name,user.userName,user.password)}>Update</button>
            </Link>
          </td>

          <td><button className='btn btn-danger'>Delete</button></td>
          </tr>
        )
      })
      
    }
  </tbody>
</table>
      </div>
    </div>
    </>
  )
}