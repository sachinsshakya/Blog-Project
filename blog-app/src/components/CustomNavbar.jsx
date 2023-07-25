import React, { useState } from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
} from 'reactstrap';
import { NavLink as ReactLink } from 'react-router-dom';

const CustomNavbar = () => {

    const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

    return (
        <div>
      <Navbar color='dark' dark expand='md' fixed=''>
        <NavbarBrand href="/">Blog App</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="me-auto" navbar>
            <NavItem>
              <NavLink to="/about" tag={ReactLink}>About</NavLink>
            </NavItem>
            <NavItem>
              <NavLink to="/login" tag={ReactLink}>
                Login
              </NavLink>
            </NavItem>
            <NavItem>
              <NavLink to="/signup" tag={ReactLink}>
                Signup
              </NavLink>
            </NavItem>
            <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>
                More
              </DropdownToggle>
              <DropdownMenu right>
                <DropdownItem to="/services" tag={ReactLink}>Services</DropdownItem>
                <DropdownItem>Contact</DropdownItem>
                <DropdownItem divider />
                <DropdownItem>Link</DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
          <NavbarText>Simple Text</NavbarText>
        </Collapse>
      </Navbar>
    </div>
    )
}

export default CustomNavbar;