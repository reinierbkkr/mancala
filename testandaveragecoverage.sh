# Run your build and tests
./gradlew clean test -Pversion="${CI_PIPELINE_ID}-${CI_COMMIT_BRANCH}-${CI_COMMIT_SHORT_SHA}"

# Extract all line coverage percentages from the console output
coverages=($(./gradlew test | grep -oE 'Line Coverage: ([0-9.]+)%' | grep -oE '[0-9.]+'))

# Calculate the total coverage and the number of coverages found
total_coverage=0
num_coverages=${#coverages[@]}

# Loop through each coverage and sum them up
for coverage in "${coverages[@]}"; do
  total_coverage=$(echo "$total_coverage + $coverage" | bc)
done

# Calculate the average coverage
average_coverage=$(echo "scale=2; $total_coverage / $num_coverages" | bc)

# Print the average coverage
echo "Average Coverage: ${average_coverage}%"