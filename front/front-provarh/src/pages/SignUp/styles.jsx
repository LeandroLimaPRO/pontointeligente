import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100vh;
`;

export const Form = styled.form`
  width: 400px;
  background: #fff;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  img {
    width: 50%;
    margin: 10px 0 40px;
  }
  p {
    color: #ff3333;
    margin-bottom: 30px;
    border: 2px solid #ff3333;
    padding: 40px;
    width: 100%;
    text-align: center;
  }
  input {
    flex: 1;
    height: 100px;
    margin-bottom: 20px;
    padding: 10 30px;
    color: #777;
    font-size: 15px;
    width: 100%;
    border: 1px solid #ddd;
    &::placeholder {
      color: #999;
    }
  }
  button {
    color: #fff;
    font-size: 16px;
    background: #8e24aa;
    height: 56px;
    border: 0;
    border-radius: 5px;
    width: 100%;
  }
  hr {
    margin: 40px 0;
    border: none;
    border-bottom: 10px solid #cdcdcd;
    width: 100%;
  }
  a {
    font-size: 18;
    font-weight: bold;
    color: #999;
    text-decoration: none;
  }
`;