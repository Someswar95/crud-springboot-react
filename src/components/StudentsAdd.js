import {
  Button,
  FormControl,
  FormGroup,
  FormHelperText,
  Input,
  InputLabel,
  Typography,
} from "@mui/material";
import { signUp } from "./services/UserService";
import { Container } from "@mui/system";
import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";

export default function StudentsAdd() {
  const [data, setData] = useState({
    name: "",
    email: "",
  });

  // useEffect(()=>{
  //   console.log(data);
  // },[data])

  //handle Change
  const handleChange = (event, property) => {
    //dynamic setting the value
    setData({ ...data, [property]: event.target.value });
  };

  //submit the form
  const submitForm = (event) => {
    event.preventDefault();

    console.log(data);

    //data validate

    //call server api for sending the data
    signUp(data)
      .then((resp) => {
        console.log(data);
        console.log("Success log");
        toast.success("User is added successfully !!")
        setData({
          name: "",
          email: "",
        })
      })
      .catch((error) => {
        console.log(error);
        console.log("Error log");
      });
  };

  return (
    <>
      <Container>
        <Typography variant="h6">Add Multiple Students</Typography>
        {/* {JSON.stringify(data)} */}
      </Container>
      <form onSubmit={submitForm}>
        <FormControl>
          <FormGroup>
            <InputLabel htmlFor="my-input">Name</InputLabel>
            <Input
              onChange={(e) => handleChange(e, "name")}
              value={data.name}
              id="name"
              type="text"
              aria-describedby="my-helper-text"
            />
            <FormHelperText id="my-helper-text">
              Put in your verified name.
            </FormHelperText>
          </FormGroup>
        </FormControl>
        <FormControl>
          <FormGroup>
            <InputLabel htmlFor="my-input">Email</InputLabel>
            <Input
              onChange={(e) => handleChange(e, "email")}
              value={data.email}
              id="email"
              type="email"
              aria-describedby="my-helper-text"
            />
            <FormHelperText id="my-helper-text">
              We'll never share your email.
            </FormHelperText>
          </FormGroup>
        </FormControl>
        <Button type="submit" variant="contained" color="success">
          Success
        </Button>
      </form>
    </>
  );
}
