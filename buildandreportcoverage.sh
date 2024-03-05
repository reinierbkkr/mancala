# Run your build and tests, capturing both build outputs and coverage percentages
build_output=$(./gradlew clean build -Pversion="${CI_PIPELINE_ID}-${CI_COMMIT_BRANCH}-${CI_COMMIT_SHORT_SHA}" 2>&1)
coverage_output=$(echo "$build_output" | grep -oE 'Line Coverage: ([0-9.]+)%')

# Calculate average coverage
average_coverage=$(echo "$coverage_output" | grep -oE '[0-9.]+' | awk '{ total += $1 } END { print total / NR }')

# Print build outputs
echo "Build Outputs:"
echo "$build_output"
echo

# Print the average coverage
echo "Average Coverage: ${average_coverage}%"