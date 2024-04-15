import React from "react";
import { Link } from "react-router-dom";

const NavBar = () => {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark mb-5 p-2">
      <Link className="navbar-brand" to={"/"}>
        SBR-Demo
      </Link>
      <button
        className="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav">
          <li className="nav-item active">
            <Link className="nav-link" to={"/view-students"}>
              View All Students
              {/* <span className="sr-only">(current)</span> */}
            </Link>
          </li>
          <li className="nav-item">
            <Link className="nav-link" to={"/add-student"}>
              Add Student
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default NavBar;
