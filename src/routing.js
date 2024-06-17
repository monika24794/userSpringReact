import React from "react";
import ReactDOM from "react-dom/client";
import {
    createBrowserRouter
} from

    "react-router-dom";
    import App from "./App";
import Home from "./Component/Home";
import Read from "./Component/Read";
import Create from "./Component/Create";
import Update from "./Component/Update";



const customRouter = createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        children: [
            {
                path: "/home",
                element: <Home />,
            },
            {
                path: "/read",
                element: <Read />,
            },
            {
                path: "/create",
                element: <Create />,
            },
            {
                path: "/update",
                element: <Update />,
            },
        ],
    },
]);
export default customRouter;