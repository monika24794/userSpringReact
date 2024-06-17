import axios from 'axios';
import React, { useRef, useState } from 'react'

export default function Update() {
    const [userName, setUserName] = useState("");
    let id = localStorage.getItem('id')
    let name = localStorage.getItem(' name ')
    let userName = localStorage.getItem('userName')
    let password = localStorage.getItem('password')
    const handleUpdate = () =>{
        axios.put(`http://localhost:9595/user/update.${id}`,{
            
        })
    }
  return (
   <>
   <div className="container mt-3 mb-3">
        <form className='myForm p-3'>
          <div className='text-center'>
            <h2>Update user</h2>
          </div>
          {/* <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="email" class="form-control" id="exampleInputName"  />
          </div> */}
          <div class="mb-3">
            <label class="form-label">Username</label>
            <input type="email" class="form-control" id="exampleInputName"   />
          </div>
          <div class="mb-3">
            <label class="form-label">Password</label>
            <input type="email" class="form-control" id="exampleInputName" />
          </div>
          <button type="submit" class="btn btn-primary" onClick={handleUpdate}>Submit</button>
        </form>
      </div>
   
   </>
  )
}
