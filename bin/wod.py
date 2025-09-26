#!/usr/bin/env python3

import pandas as pd
import xarray as xr
from wodpy import wod
import os
import argparse
from pathlib import Path


def read_data(filepath):
    """
    Reads XBT data from a simple ASCII text file.
    Assumes two columns: depth and temperature.
    """
    try:
        fid = open("{}".format(filepath), newline=None)
        profile = wod.WodProfile(fid)
        return profile
    except FileNotFoundError:
        print(f"Error: File not found at {filepath}")
        return None
    except Exception as e:
        print(f"An error occurred while reading the file: {e}")
        return None

def main():
    parser = argparse.ArgumentParser(description="Process a file path from command-line arguments.")
    parser.add_argument('--file', '-f', type=Path, required=True,
                        help='The path to the file to be processed.')
    args = parser.parse_args()
    input_file_path = args.file

    profile = read_data(input_file_path)
    if profile is not None:
        print("latitude: %s" % profile.latitude())
        print("longitude: %s" % profile.longitude())
        print("depths: %s" % profile.z())
        print("data frames: %s" % profile.df())

if __name__ == "__main__":
    main()
