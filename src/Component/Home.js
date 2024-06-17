import React from 'react'
import {Link}  from 'react-router-dom'
export default function Home() {
  return (
    <>

      <div className="container" mt-3 mb-3>
        <h1>User Management System</h1>
        <div className="row" mt-5 mb-t p-3 >
          <div className="col-xl-6"><div class="card ">
            <div class="card-body">
              <h5 class="card-title">Users</h5>
              <p class="card-text">Please click button to get users</p>
              <Link to="/read" class="btn btn-primary">Users</Link>
            </div>
          </div></div>
          <div className="col-xl-6"><div class="card">
            <div class="card-body">
              <h5 class="card-title">Rgister User</h5>
              <p class="card-text">Please click for registration of new user.</p>
              <Link to="/create" class="btn btn-primary">Register</Link>
            </div>
          </div></div>
        </div>
      </div>




    </>
  )
}
