import logo from "../assets/Logo2.png"
import {useState} from "react";
import CartDropdown from "./CartDropdown";

const Navbar = () => {
    const logoStyle = {maxHeight: "20vh"};
    const [navbarMenuAddOnClass, setNavbarMenuAddOnClass] = useState("");
    function toggleNavbarBurgerMenu(event) {
        if (navbarMenuAddOnClass === "") {
            setNavbarMenuAddOnClass("is-active");
        } else {
            setNavbarMenuAddOnClass("");
        }
    }

    const navbarItemStyle = "navbar-item is-size-6-desktop is-size-4-tablet is-size-5-mobile";
    return (
        <div className="navbar has-shadow is-white">
            <div className="navbar-brand">
                <a href={"/"} className="navbar-item">
                    <img src={logo} alt="brand logo" style={logoStyle}/>
                </a>

                <a className="navbar-burger" id="burger"
                    onClick={toggleNavbarBurgerMenu}>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
            </div>

            <div className={ "navbar-menu" + " " + navbarMenuAddOnClass } id="nav-links">
                <div className="navbar-end">
                    <a className={navbarItemStyle}>
                        My Account
                    </a>
                    <a href="#/cart" className={navbarItemStyle}>
                        Shopping Cart (0)
                    </a>
                    <a className={navbarItemStyle}>
                        About
                    </a>
                </div>
            </div>
        </div>
    );
}

export default Navbar;