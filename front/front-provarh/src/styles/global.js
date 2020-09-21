import { createGlobalStyle } from "styled-components";

import "font-awesome/css/font-awesome.css";

createGlobalStyle`
* {
  box-sizing: border-box;
  padding: 20px;
  margin: 30px;
  outline: 0;
}
body, html {
  background: #eee;
  font-family: 'Helvetica Neue', 'Helvetica', Arial, sans-serif;
  text-rendering: optimizeLegibility !important;
  -webkit-font-smoothing: antialiased !important;
  height: 100%;
  width: 100%;
}
`;